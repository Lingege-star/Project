package com.example.day08.map.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OKManager_ProRetroBuilderFactory implements Factory<Retrofit.Builder> {
  private final OKManager module;

  public OKManager_ProRetroBuilderFactory(OKManager module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Retrofit.Builder get() {
    return Preconditions.checkNotNull(
        module.proRetroBuilder(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit.Builder> create(OKManager module) {
    return new OKManager_ProRetroBuilderFactory(module);
  }
}
