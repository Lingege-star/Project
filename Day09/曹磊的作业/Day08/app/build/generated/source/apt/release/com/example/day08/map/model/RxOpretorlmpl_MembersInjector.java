package com.example.day08.map.model;

import com.example.day08.map.model.api.ApiService;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RxOpretorlmpl_MembersInjector implements MembersInjector<RxOpretorlmpl> {
  private final Provider<ApiService> mApiServiceProvider;

  public RxOpretorlmpl_MembersInjector(Provider<ApiService> mApiServiceProvider) {
    assert mApiServiceProvider != null;
    this.mApiServiceProvider = mApiServiceProvider;
  }

  public static MembersInjector<RxOpretorlmpl> create(Provider<ApiService> mApiServiceProvider) {
    return new RxOpretorlmpl_MembersInjector(mApiServiceProvider);
  }

  @Override
  public void injectMembers(RxOpretorlmpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mApiService = mApiServiceProvider.get();
  }

  public static void injectMApiService(
      RxOpretorlmpl instance, Provider<ApiService> mApiServiceProvider) {
    instance.mApiService = mApiServiceProvider.get();
  }
}
