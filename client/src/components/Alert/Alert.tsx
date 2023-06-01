import React, { FC } from 'react';
import classNames from 'classnames';

import closeIcon from 'assets/images/closeIcon.svg';
import { IconButton } from 'components/IconButton/IconButton';

import styles from './Alert.module.scss';

export interface AlertProps extends Styleable {
  text?: string;
  type?: 'error' | 'warning' | 'success';
  onClose?: () => void;
}

export const Alert: FC<AlertProps> = ({
  text, type = 'error', onClose, className,
}) => {
  if (!text) {
    return null;
  }

  return (
    <section className={classNames(styles.alert, styles[type], className)} aria-label="alert">
      <div className={styles.icon} />
      <p className={styles.text}>{text}</p>
      <IconButton className={styles.close} image={closeIcon} onClick={onClose} aria-label="close alert" type="button" />
    </section>
  );
};
