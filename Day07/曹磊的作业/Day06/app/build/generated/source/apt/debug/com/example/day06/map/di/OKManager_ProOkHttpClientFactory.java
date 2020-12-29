package com.example.day06.map.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OKManager_ProOkHttpClientFactory implements Factory<OkHttpClient> {
  private final OKManager module;

  public OKManager_ProOkHttpClientFactory(OKManager module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.proOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(OKManager module) {
    return new OKManager_ProOkHttpClientFactory(module);
  }
}
