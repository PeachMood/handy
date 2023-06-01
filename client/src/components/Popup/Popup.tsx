import React, { FC } from 'react';
import classNames from 'classnames';

import { IconButton } from 'components/IconButton/IconButton';
import closeIcon from 'assets/images/closeIcon.svg';

import styles from './Popup.module.scss';

interface PopupProps extends Styleable {
  isOpened: boolean;
  onClose?: () => void;
}

export const Popup: FC<PopupProps> = ({
  isOpened, onClose, className, children,
}) => {
  const popupStyles = classNames(styles.popup, { [styles.opened]: isOpened }, className);

  return (
    <section className={popupStyles}>
      <div className={styles.container}>
        <IconButton className={styles.close} image={closeIcon} onClick={onClose} />
        {children}
      </div>
    </section>
  );
};
