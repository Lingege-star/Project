package com.example.day09.map.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OKManager_ProRetrofitFactory implements Factory<Retrofit> {
  private final OKManager module;

  public OKManager_ProRetrofitFactory(OKManager module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.proRetrofit(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(OKManager module) {
    return new OKManager_ProRetrofitFactory(module);
  }
}
