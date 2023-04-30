import React, { FC } from 'react';
import { Navigate, Outlet } from 'react-router-dom';

import { useAuthContext } from 'hooks/context/useAuthContext';

export const PrivateRoute: FC = ({ children }) => {
  const { isLoggedIn } = useAuthContext();

  if (!isLoggedIn) {
    return <Navigate to="/login" replace />;
  }

  return (
    <>
      {children}
      <Outlet />
    </>
  );
};
