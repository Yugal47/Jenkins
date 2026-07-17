import React, { useState } from "react";
import "./App.css";

const API_BASE_URL = "http://localhost:8081/api";

function App() {
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleClick = async () => {
    setLoading(true);
    setError("");
    try {
      const response = await fetch(`${API_BASE_URL}/message`);
      if (!response.ok) {
        throw new Error(`Server responded with ${response.status}`);
      }
      const data = await response.json();
      setMessage(data.message);
    } catch (err) {
      setError("Could not reach the backend. Is it running on port 8081?");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App">
      <h1>Share App</h1>
      <button onClick={handleClick} disabled={loading}>
        {loading ? "Loading..." : "Click Me"}
      </button>
      {message && <p className="message">{message}</p>}
      {error && <p className="error">{error}</p>}
    </div>
  );
}

export default App;
