import React, { FC } from 'react';

import logo from 'assets/images/logo.svg';

import styles from './Logo.module.scss';

export const Logo: FC = () => <img className={styles.logo} src={logo} alt="Handy" />;
