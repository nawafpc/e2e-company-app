import { UserConfig } from 'vite';

export function overrideVaadinConfig(customConfig: UserConfig): UserConfig {
  return (env) => {
    const vaadinConfig = {
      server: {
        hmr: true, // Enable Hot Module Replacement
      },
    };

    const mergedConfig = {
      ...vaadinConfig,
      ...(typeof customConfig === 'function' ? customConfig(env) : customConfig),
    };

    return mergedConfig;
  };
}
