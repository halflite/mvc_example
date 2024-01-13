package net.halflite.mvc.inject;

import static com.google.inject.name.Names.bindProperties;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.spi.ConfigSource;
import com.google.common.collect.Streams;
import com.google.inject.AbstractModule;

/** アプリケーションDI設定 */
public class AppModule extends AbstractModule {
  @Override
  protected void configure() {
    this.registerEnv();
    super.configure();
  }

  /** プロパティDI設定 */
  public void registerEnv() {
    final Map<String, String> props = new HashMap<>();
    Streams.stream(ConfigProvider.getConfig().getConfigSources())
        .map(ConfigSource::getProperties)
        .forEach(props::putAll);
    bindProperties(binder(), props);
  }
}
