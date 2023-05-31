import React, { FC, useState } from 'react';
import { useForm } from 'react-hook-form';

import { Form } from 'components/Form/Form';
import { ErrorInput } from 'components/ErrorInput/ErrorInput';
import { Alert } from 'components/Alert/Alert';
import { useAuthApi } from 'hooks/api/useAuthApi';

import { validationOptions } from './constants';

import styles from './RegisterForm.module.scss';

interface FormData {
  username: string;
  email: string;
  password: string;
  confirm: string;
}

interface RegisterFormProps {
  onSuccess: (email: string) => void;
}

export const RegisterForm: FC<RegisterFormProps> = ({ onSuccess }) => {
  const {
    register, handleSubmit, formState: { errors }, watch,
  } = useForm<FormData>({ mode: 'onChange' });
  const authApi = useAuthApi();

  const [alertMessage, setAlertMessage] = useState<string>(null);
  const handleAlertClose = () => {
    setAlertMessage(null);
  };

  const handleRegister = async ({ username, email, confirm }: FormData) => {
    try {
      await authApi.register(username, email, confirm);
      onSuccess(email);
    } catch (error) {
      if (!error.response) {
        setAlertMessage('The server is not responding.');
      } else if (error.response.status === 400) {
        setAlertMessage('Invalid registration data.');
      } else if (error.response.status === 409) {
        setAlertMessage('User already exists.');
      } else {
        setAlertMessage('Registration failed.');
      }
    }
  };

  return (
    <Form className={styles.form} title="Register" text="Register" onSubmit={handleSubmit(handleRegister)}>
      <Alert className={styles.alert} text={alertMessage} onClose={handleAlertClose} />
      <ErrorInput
        className={styles.input}
        placeholder="Username"
        isInvalid={!!errors.username}
        errorMessage={errors.username?.message}
        {...register('username', validationOptions.username)}
      />
      <ErrorInput
        className={styles.input}
        placeholder="Email"
        isInvalid={!!errors.email}
        errorMessage={errors.email?.message}
        {...register('email', validationOptions.email)}
      />
      <ErrorInput
        className={styles.input}
        type="password"
        placeholder="Password"
        isInvalid={!!errors.password}
        errorMessage={errors.password?.message}
        {...register('password', validationOptions.password)}
      />
      <ErrorInput
        className={styles.input}
        type="password"
        placeholder="Confirm password"
        isInvalid={!!errors.confirm}
        errorMessage={errors.confirm?.message}
        {...register('confirm', {
          required: true,
          validate: (password) => watch('password') === password || 'Passwords must match.',
        })}
      />
    </Form>
  );
};
