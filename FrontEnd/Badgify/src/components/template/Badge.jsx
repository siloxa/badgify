import styles from './badge.module.css';
import SideBar from '../module/SideBar';
import Modal from '../module/Modal';
import { useContext, useState } from 'react';
import BadgeCard from '../module/BadgeCard';
import { Link } from 'react-router-dom';
import AuthContext from '../../contexts/AuthContext';
function Badge() {
  const [modal, setModal] = useState(false);
  const {token}= useContext(AuthContext)
  console.log(token)
 
  return (
    <div className={styles.main}>
      <div className={styles.sidbar}>
        <SideBar />
      </div>
      <div className={styles.badge}>
        <div className={styles.container}>
          <div className={styles.badgeBtn}>
            <input placeholder="search" />
            <Link to="/badge/create" className={styles.btn}>
            CREATE CUSTOMIZED BADGE
            </Link>
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
