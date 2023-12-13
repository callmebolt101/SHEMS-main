import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import ProtectedRoute from './components/ProtectedRoute'; // Ensure this path is correct
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import CustomerDashboard from './components/CustomerDashboard';
import EnergyDetails from './components/EnergyDetails';
// Other imports...

function App() {
  return (
    <Router>
      <div className="app">
        <nav className="navbar">
          <div className="logo">Logo</div>
          <div className="menu">
            <Link to="/" className="btn-home">HOME</Link>
            <Link to="/about" className="btn-demo">ABOUT US</Link>
          </div>
        </nav>

        <Routes>
          <Route exact path="/" element={
            <header className="header">
              <div className="header-content">
                <h1>THE EASIEST WAY TO ANALYZE YOUR ENERGY CONSUMPTION</h1>
                <Link to="/login" className="btn-header-demo">GET SMARTER</Link>
              </div>
            </header>
          }/>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/dashboard" element={
            <ProtectedRoute>
              <CustomerDashboard />
            </ProtectedRoute>
          } />
          <Route path="/energydetails" element={<EnergyDetails/>} />
          <Route path="/about" element={<div>About Us</div>} />
          {/* Add more routes as needed */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
