// import { UserConfigFn } from 'vite';
// import { overrideVaadinConfig } from './vite.generated';
//
// const customConfig: UserConfigFn = (env) => ({
//   // Here you can add custom Vite parameters
//   // https://vitejs.dev/config/
// });
//
// export default overrideVaadinConfig(customConfig);
import { defineConfig } from 'vite';
import { overrideVaadinConfig } from './vite.generated'; // Ensure this file exists and is correctly referenced

// Custom Vite configuration
const customConfig = {
  // Base URL for the application (change as needed)
  base: '/',

  // Configure server settings
  server: {
    port: 3000, // Specify the port your app will run on
    open: true, // Automatically open the app in the browser on start
  },

  // Configure build options
  build: {
    outDir: 'dist', // Output directory for the build
    sourcemap: true, // Enable source maps for easier debugging
  },

  // Add any other custom Vite parameters you might need
};

// Export the overridden Vaadin configuration with the custom Vite settings
export default overrideVaadinConfig(() => customConfig);
