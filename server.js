import express from 'express';
import path from 'path';

const app = express();
const port = process.env.PORT || 3000;

// Serve static files from the 'dist' directory
app.use(express.static(path.join(process.cwd(), 'dist'))); // Changed to process.cwd()

// Serve the index.html file for all routes
app.get('*', (req, res) => {
  res.sendFile(path.join(process.cwd(), 'dist', 'index.html')); // Changed to process.cwd()
});

// Start the server
app.listen(port, '0.0.0.0', () => {
  console.log(`Server running at http://localhost:${port}`);
});
