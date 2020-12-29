package com.example.day09.map.di;

import com.example.day09.map.model.api.ApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OKManager_ProApiServiceFactory implements Factory<ApiService> {
  private final OKManager module;

  public OKManager_ProApiServiceFactory(OKManager module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ApiService get() {
    return Preconditions.checkNotNull(
        module.proApiService(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiService> create(OKManager module) {
    return new OKManager_ProApiServiceFactory(module);
  }
}
