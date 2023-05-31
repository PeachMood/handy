import React, { FC, useState } from 'react';

import { RegisterForm } from './RegisterForm/RegisterForm';
import { SuccessPopup } from './SuccessPopup/SuccessPopup';

import styles from './Register.module.scss';

export const Register: FC = () => {
  const [email, setEmail] = useState<string>(null);

  const handleSuccess = (email: string) => {
    setEmail(email);
  };

  return (
    <div className={styles.page}>
      {email ? <SuccessPopup email={email} /> : <RegisterForm onSuccess={handleSuccess} />}
    </div>
  );
};
