import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import '../LoginPage.css'; // Make sure this path is correct

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(''); // State for handling login error messages
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();
    setError(''); // Reset error message on new login attempt

    try {
      const response = await fetch('http://localhost:8080/users/login_users', { // Adjust the URL to your backend
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });

      if (response.ok) {
        const data = await response.json();
        localStorage.setItem('token', data.token); // Adjust based on how your backend sends the token
        navigate('/dashboard'); // Redirect to dashboard
      } else {
        console.error('Login failed');
        setError('Invalid email or password.'); // Set error message for failed login
      }
    } catch (error) {
      console.error('Login error', error);
      setError('Failed to connect. Please try again later.'); // Set error message for network errors
    }
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <h2>Welcome to SHEMS</h2>
        <p>Please Sign In</p>
        {error && <p className="error-message">{error}</p>} {/* Display error message */}
        <form onSubmit={handleLogin} className="login-form">
          <div className="input-group">
            <label htmlFor="email">Email or Username</label>
            <input
              id="email"
              type="text"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Enter your email or username"
              required
            />
          </div>
          <div className="input-group">
            <label htmlFor="password">Password</label>
            <input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Enter your password"
              required
            />
          </div>
          <div className="forgot-password">
            <Link to="/forgot-password">Forgot Password?</Link>
          </div>
          <div className="form-actions">
            <button type="submit" className="btn-sign-in">Sign in</button>
          </div>
        </form>
        <p className="signup-text">
          New on our platform? <Link to="/register">Create an account</Link>
        </p>
      </div>
    </div>
  );
};

export default LoginPage;
