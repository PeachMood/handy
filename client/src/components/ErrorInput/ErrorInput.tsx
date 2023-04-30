import React, { forwardRef, InputHTMLAttributes } from 'react';

import { Input } from 'components/Input/Input';

import styles from './ErrorInput.module.scss';

export interface ErrorInputProps extends InputHTMLAttributes<HTMLInputElement> {
  isInvalid?: boolean;
  errorMessage?: string;
}

export const ErrorInput = forwardRef<HTMLInputElement, ErrorInputProps>(({
  isInvalid, errorMessage, className, ...props
}, ref) => (
  <label className={className}>
    <Input isInvalid={isInvalid} ref={ref} {...props} />
    <span className={styles.error}>{errorMessage}</span>
  </label>
));
