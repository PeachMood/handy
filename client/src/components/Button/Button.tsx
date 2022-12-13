import React from 'react';
import classNames from 'classnames';

import styles from './Button.module.scss';

interface ButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  color?: 'primary' | 'accent';
  size?: 'medium' | 'large' | 'huge';
}

export const Button = ({
  color = 'primary', size = 'medium', className, ...props
}: ButtonProps): JSX.Element => {
  const classes = classNames(
    styles.button,
    styles[color],
    styles[size],
    className,
  );

  return <button className={classes} {...props} />;
};
