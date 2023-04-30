import React, { useState, FC } from 'react';
import { useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';

import { Form } from 'components/Form/Form';
import { ErrorInput } from 'components/ErrorInput/ErrorInput';
import { Checkbox } from 'components/Checkbox/Checkbox';
import { TextButton } from 'components/TextButton/TextButton';
import { Alert } from 'components/Alert/Alert';
import { useAuthContext } from 'hooks/context/useAuthContext';
import { useAuthApi } from 'hooks/api/useAuthApi';

import styles from './LoginForm.module.scss';
import { validationOptions } from './constants';

interface FormData {
  username: string;
  password: string;
  remember: boolean;
}

export const LoginForm: FC = () => {
  const { setIsLoggedIn, setAccessToken } = useAuthContext();
  const authApi = useAuthApi();
  const navigate = useNavigate();

  const [alertMessage, setAlertMessage] = useState<string>(null);
  const handleAlertClose = () => {
    setAlertMessage(null);
  };

  const { register, handleSubmit, formState: { errors } } = useForm<FormData>({ mode: 'onSubmit' });
  const handleLogin = async ({ username, password }: FormData) => {
    try {
      const response = await authApi.login(username, password);
      setAccessToken(response.data?.accessToken);
      setIsLoggedIn(true);
      navigate('/notes', { replace: true });
    } catch (error) {
      if (!error.response) {
        setAlertMessage('The server is not responding.');
      } else if (error.response.status === 400) {
        setAlertMessage('Missing username or password.');
      } else {
        setAlertMessage('Login failed.');
      }
    }
  };

  return (
    <Form className={styles.form} title="Login" text="Login" onSubmit={handleSubmit(handleLogin)}>
      <Alert className={styles.alert} text={alertMessage} onClose={handleAlertClose} />
      <ErrorInput
        className={styles.input}
        placeholder="Email or username"
        isInvalid={!!errors.username}
        errorMessage={errors.username?.message}
        {...register('username', validationOptions.username)}
      />
      <ErrorInput
        className={styles.input}
        placeholder="Password"
        type="password"
        isInvalid={!!errors.password}
        errorMessage={errors.password?.message}
        {...register('password', validationOptions.password)}
      />
      <div className={styles.field}>
        <Checkbox label="Remember me" />
        <TextButton color="accent" size="small">Forgot password?</TextButton>
      </div>
    </Form>
  );
};
