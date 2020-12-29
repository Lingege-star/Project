package com.example.day09.map.di;

import com.example.day09.map.model.RxOpretorlmpl;
import com.example.day09.map.model.RxOpretorlmpl_MembersInjector;
import com.example.day09.map.model.api.ApiService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerokComponent implements okComponent {
  private Provider<ApiService> proApiServiceProvider;

  private MembersInjector<RxOpretorlmpl> rxOpretorlmplMembersInjector;

  private DaggerokComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static okComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.proApiServiceProvider =
        DoubleCheck.provider(OKManager_ProApiServiceFactory.create(builder.oKManager));

    this.rxOpretorlmplMembersInjector = RxOpretorlmpl_MembersInjector.create(proApiServiceProvider);
  }

  @Override
  public void getSingleApiService(RxOpretorlmpl impl) {
    rxOpretorlmplMembersInjector.injectMembers(impl);
  }

  public static final class Builder {
    private OKManager oKManager;

    private Builder() {}

    public okComponent build() {
      if (oKManager == null) {
        this.oKManager = new OKManager();
      }
      return new DaggerokComponent(this);
    }

    public Builder oKManager(OKManager oKManager) {
      this.oKManager = Preconditions.checkNotNull(oKManager);
      return this;
    }
  }
}
