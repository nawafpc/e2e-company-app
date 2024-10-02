// import { UserConfigFn } from 'vite';
// import { overrideVaadinConfig } from './vite.generated';
//
// const customConfig: UserConfigFn = (env) => ({
//   // Here you can add custom Vite parameters
//   // https://vitejs.dev/config/
// });
//
// export default overrideVaadinConfig(customConfig);
// fault overrideVaadinConfig(() => customConfig);
// import { defineConfig } from 'vite';
// import { overrideVaadinConfig } from './vite.generated'; // Ensure vite.generated.ts exists and is properly referenced
//
// // Custom Vite configuration
// const customConfig = {
//   // Base URL for the application (change as needed)
//   base: '/',
//
//   // Configure server settings
//   server: {
//     port: 15006, // Specify the port your app will run on
//     open: true,  // Automatically open the app in the browser on start
//   },
//
//   // Configure build options
//   build: {
//     outDir: 'dist',      // Output directory for the build
//     sourcemap: true,     // Enable source maps for easier debugging
//   },
//
//   // Add any other custom Vite parameters you might need
// };
//
// // Export the overridden Vaadin configuration with the custom Vite settings
// export default overrideVaadinConfig(() => customConfig);

import { defineConfig } from 'vite';
import { overrideVaadinConfig } from './vite.generated';

// Custom Vite configuration
const customConfig = {
  // Base URL for the application (leave it as '/' for relative paths)
  base: '/',

  // Configure server settings
  server: {
    port: process.env.PORT || 3000, // Use Render-provided PORT, fallback to 3000 locally
    open: false, // Disable auto-open in the browser (since Render uses a remote URL)
  },

  // Configure build options
  build: {
    outDir: 'dist',      // Output directory for the build
    sourcemap: true,     // Enable source maps for easier debugging
  },

  // Add any other custom Vite parameters you might need
};

// Export the overridden Vaadin configuration with the custom Vite settings
export default overrideVaadinConfig(() => customConfig);
