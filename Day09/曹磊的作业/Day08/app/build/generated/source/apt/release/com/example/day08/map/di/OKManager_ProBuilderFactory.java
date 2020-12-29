package com.example.day08.map.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OKManager_ProBuilderFactory implements Factory<OkHttpClient.Builder> {
  private final OKManager module;

  public OKManager_ProBuilderFactory(OKManager module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient.Builder get() {
    return Preconditions.checkNotNull(
        module.proBuilder(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient.Builder> create(OKManager module) {
    return new OKManager_ProBuilderFactory(module);
  }
}
