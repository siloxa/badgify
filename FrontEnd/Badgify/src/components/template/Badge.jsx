import styles from './badge.module.css';
import SideBar from '../module/SideBar';
function Badge() {
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
      </div>
    </div>
  );
}

export default Badge;
