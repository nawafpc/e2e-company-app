
// import { defineConfig } from 'vite';
// import { overrideVaadinConfig } from './vite.generated';

// // Custom Vite configuration
// const customConfig = {
//   // Base URL for the application (leave it as '/' for relative paths)
//   base: '/',

//   // Configure server settings
//   server: {
//     host: '0.0.0.0',  // Bind to 0.0.0.0 to allow external access
//     port: process.env.PORT || 3000, // Use Render-provided PORT, fallback to 3000 locally
//     open: false, // Disable auto-open in the browser (since Render uses a remote URL)
//   },

//   // Configure build options
//   build: {
//     outDir: 'dist',      // Output directory for the build
//     sourcemap: true,     // Enable source maps for easier debugging
//   },

//   // Add any other custom Vite parameters you might need
// };


// // Export the overridden Vaadin configuration with the custom Vite settings
// export default overrideVaadinConfig(() => customConfig);
import { defineConfig } from 'vite';
import { overrideVaadinConfig } from './vite.generated';

// Custom Vite configuration
const customConfig = defineConfig({
  // Base URL for the application (leave it as '/' for relative paths)
  base: '/',  // Use relative paths to work with Vercel

  // Configure server settings
  server: {
    host: '0.0.0.0', // Bind to 0.0.0.0 to allow external access
    port: process.env.PORT || 3000, // Use Render-provided PORT, fallback to 3000 locally
    open: false, // Disable auto-open in the browser (since Render uses a remote URL)
  },

  // Configure build options
  build: {
    outDir: 'dist', // Output directory for the build
    sourcemap: true, // Enable source maps for easier debugging
    rollupOptions: {
      input: 'index.html', // Ensure this points to your index.html
    },
  },
});

// Export the overridden Vaadin configuration with the custom Vite settings
export default overrideVaadinConfig(() => customConfig);
