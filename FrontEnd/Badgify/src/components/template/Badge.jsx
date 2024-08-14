import styles from './badge.module.css';
import SideBar from '../module/SideBar';
import Modal from '../module/Modal';
import { useState } from 'react';
function Badge() {
  const [modal, setModal] = useState(true);
  return (
    <div className={styles.main}>
      <div className={styles.sidbar}>
        <SideBar />
      </div>
      <div className={styles.badge}>
        <div className={styles.container}>
          <div className={styles.badgeBtn}>
            <input placeholder="search" />
            <button>CREATE CUSTOMIZED BADGE</button>
          </div>
        </div>
        {!!modal && <Modal />}
      </div>
    </div>
  );
}

export default Badge;
