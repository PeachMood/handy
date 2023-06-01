import React, { FC, InputHTMLAttributes } from 'react';
import classNames from 'classnames';

import { Input } from 'components/Input/Input';

import styles from './IconInput.module.scss';

export interface IconInput extends InputHTMLAttributes<HTMLInputElement> {
  image: string;
}

export const IconInput: FC<IconInput> = ({ image, className, ...props }) => {
  const inputStyles = classNames(styles.input, className);

  return (
    <Input style={{ backgroundImage: `url(${image})` }} className={inputStyles} {...props} />
  );
};
