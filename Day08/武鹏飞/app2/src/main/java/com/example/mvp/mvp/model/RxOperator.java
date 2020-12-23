package com.example.mvp.mvp.model;


import com.example.mvp.callback.RxObserverCallBack;

import java.util.function.Consumer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 用来封装各种操作符
 * 需要返回值，其他方法才能调用这个方法
 */
public class RxOperator {
    //封装网络请求时切换的线程的方法
    //subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

    //切换线程的返回值的是Observable<ResponseBody>,因为可能有Bean类，参数改为object
    //ObservableSource接口是Observable的父类，多态调用：父类引用指向子类对象
//    public static ObservableSource<Object> threadTransformer(Observable observable) {

    //下方concatMap操作符中需要Observable接口中的方法，ObservableSource接口中没有，需要改变成Observable
    public static Observable<Object> threadTransformer(Observable observable) {
        //切换线程
        return observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread());
    }

    //封装了ConcatMap操作符   网络嵌套(注册完成之后自动登录)
    //参数：注册的信息、登录的信息、接口回调的方法
    public <T> ObservableSource concatMap(Observable<T> registerObservable,
                                          Observable<T> loginObservable,RxObserverCallBack<T> callBack) {


//        return threadTransformer(registerObservable).doOnNext(new Consumer() {  //Consumer消费者
//            @Override//accept接受
//            public void accept(Object o) throws Exception {
//
//            }
//            //要转换成新事件了，上个事件还在主线程需要再次切换到子线程进行网络请求
//            //Function 功能
//        }).observeOn(Schedulers.io()).concatMap(new Function() {
//            @Override
//            public Object apply(Object input) {
//                return loginObservable;
//            }
//        }).observeOn(AndroidSchedulers.mainThread());

        //拉姆达表达式：在调用内部类的方法时使用，开头的属性是根据内部类的属性决定的
        //单属性时
//        Button button = new Button(App.context());
//        button.setOnClickListener(v->{
//        });

        //多属性时
//        CheckBox checkBox = new CheckBox(App.context());
//        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
//        });

        //属性是Runnable线程时
//        new Thread(()-> Log.d("TAG", "concatMap: ")).start();


        return threadTransformer(registerObservable).
                doOnNext(obj-> {
                    //接口回调，更新UI
                    callBack.onSuccessData((T) obj);
                }).observeOn(Schedulers.io()).
                concatMap(obj->{
                return loginObservable;
        });

    }
}

