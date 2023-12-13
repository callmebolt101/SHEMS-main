import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import '../CustomerDashboard.css'; // Ensure CSS file is linked

const CustomerDashboard = () => {
  const [customer, setCustomer] = useState(null);
  const [devices, setDevices] = useState([]);
  const [locations, setLocations] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('userId'); // Assuming you store userId in local storage upon login

    const fetchData = async () => {
      // Fetch customer details
      try {
        const customerResponse = await fetch(`http://localhost:3000/customer/${userId}`, {
          headers: {
            'Authorization': `Bearer ${token}`
          }
        });
        const customerData = await customerResponse.json();
        setCustomer(customerData);

        // Fetch devices and locations if necessary
        // ...
      } catch (error) {
        console.error('Error:', error);
      }
    };

    if (userId && token) {
      fetchData();
    } else {
      console.log('User ID or Token not found');
      // Handle the case when user ID or token is not available
    }
  }, []);

  return (
    <div className="dashboard">
      <header className="dashboard-header">
        <h1>Customer Details</h1>
      </header>
      <main className="dashboard-content">
        {/* ... Rest of the component */}
      </main>
    </div>
  );
};

export default CustomerDashboard;
