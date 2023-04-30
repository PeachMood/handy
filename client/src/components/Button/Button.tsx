import React, { FC, ButtonHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './Button.module.scss';

export interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  color?: 'primary' | 'accent';
  size?: 'medium' | 'large' | 'huge';
}

export const Button: FC<ButtonProps> = ({
  color = 'primary', size = 'medium', className, ...props
}) => {
  const classes = classNames(
    styles.button,
    styles[color],
    styles[size],
    className,
  );

  return <button className={classes} {...props} />;
};
