import React, { FC } from 'react';
import { Navigate, Outlet } from 'react-router-dom';

import { useAuthContext } from 'hooks/context/useAuthContext';

export const PublicRouter: FC = ({ children }) => {
  const { isLoggedIn } = useAuthContext();

  if (isLoggedIn) {
    return <Navigate to="/notes" replace />;
  }

  return (
    <>
      {children}
      <Outlet />
    </>
  );
};
