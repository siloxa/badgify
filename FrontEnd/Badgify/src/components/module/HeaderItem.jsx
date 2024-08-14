import React from 'react';
import { NavLink, useLocation } from 'react-router-dom';
import styles from './headerItem.module.css';

function HeaderItem({ children, to }) {
  const location = useLocation();
  const navStyle = location.pathname === '/' ? styles.navLink : styles.navLinkTwo;
  const dotStyle = location.pathname === '/' ? styles.activeIndicator : styles.activeIndicatorTwo;
  return (
    <div>
      <NavLink to={to} className={({ isActive }) => (isActive ? `${navStyle} ${styles.active}` : navStyle)}>
        {({ isActive }) => (
          <div className={styles.flexDoted}>
            {children}
            {isActive && <span className={dotStyle}>●</span>}
          </div>
        )}
      </NavLink>
    </div>
  );
}

export default HeaderItem;
