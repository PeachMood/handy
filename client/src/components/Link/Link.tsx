import React from 'react';
import classNames from 'classnames';

import styles from './Link.module.scss';

interface LinkProps extends React.AnchorHTMLAttributes<HTMLAnchorElement> {
  color?: 'primary' | 'accent';
  size?: 'medium' | 'large';
  underlined?: boolean;
}

export const Link = ({
  className, color = 'primary', size = 'medium', href, children, ...props
}: LinkProps): JSX.Element => {
  const classes = classNames(
    styles.link,
    styles[color],
    styles[size],
    className,
  );

  return <a href={href} className={classes} {...props}>{children}</a>;
};
