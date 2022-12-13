import React from 'react';
import classNames from 'classnames';

import styles from './TextButton.module.scss';

interface TextButtonProps extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  color?: 'primary' | 'accent';
  size?: 'medium' | 'large';
}

export const TextButton = ({
  className, color = 'primary', size = 'medium', ...props
}: TextButtonProps): JSX.Element => {
  const classes = classNames(
    styles.textButton,
    styles[color],
    styles[size],
    className,
  );

  return <button className={classes} {...props} />;
};
