import styles from './badge.module.css';
import SideBar from '../module/SideBar';
import Modal from '../module/Modal';
import { useState } from 'react';
import BadgeCard from '../module/BadgeCard';
function Badge() {
  const [modal, setModal] = useState(false);
 
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
          <div>
            <BadgeCard setModal={setModal} />
          </div>
        </div>
        {!!modal && <Modal setModal={setModal} />}
      </div>
    </div>
  );
}

export default Badge;
