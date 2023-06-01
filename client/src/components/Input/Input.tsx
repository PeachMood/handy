import React, { forwardRef, InputHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './Input.module.scss';

export interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  isInvalid?: boolean;
}

export const Input = forwardRef<HTMLInputElement, InputProps>((props, ref) => {
  const { isInvalid, className, ...otherProps } = props;

  const classes = classNames(
    styles.input,
    { [styles.invalid]: isInvalid },
    className,
  );

  return (
    <input className={classes} ref={ref} {...otherProps} />
  );
});
