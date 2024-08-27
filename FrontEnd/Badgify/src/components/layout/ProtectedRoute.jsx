import React, { useContext } from 'react';
import AuthContext from '../../contexts/AuthContext';
import { Navigate, Outlet } from 'react-router-dom';

function ProtectedRoute({ children }) {
  const { token } = useContext(AuthContext);
  if (!token) {
    return <Navigate to="/login" />;
  }
  return (<Outlet/>
  );
}

export default ProtectedRoute;
