import React, { FC, FormHTMLAttributes } from 'react';
import classNames from 'classnames';

import { Button } from 'components/Button/Button';

import styles from './Form.module.scss';

export interface FormProps extends FormHTMLAttributes<HTMLFormElement> {
  title: string;
  text: string;
  isInvalid?: boolean;
}

// Chidren prop allows to create forms with different content
export const Form: FC<FormProps> = ({
  title, text, className, children, ...props
}) => (
  <form className={classNames(styles.form, className)} {...props}>
    <h1 className={styles.title}>{title}</h1>
    {children}
    <Button className={styles.button} type="submit">{text}</Button>
  </form>
);
