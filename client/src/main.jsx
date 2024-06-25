import React from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";

import "./assets/styles/main.scss";
import App from "./App.jsx";

import { Provider } from "react-redux";
import store from "./store";

// Get the container element
const container = document.getElementById("root");

// Create a root and render the App component
if (container) {
  const root = createRoot(container);
  root.render(
    <React.StrictMode>
      <BrowserRouter>
        <Provider store={store}>
          <App />
        </Provider>
      </BrowserRouter>
    </React.StrictMode>
  );
}
