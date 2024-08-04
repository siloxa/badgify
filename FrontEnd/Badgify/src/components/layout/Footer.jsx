import React from 'react';
import styles from './footer.module.css';

function Footer() {
  return (
    <footer>
      <div className={styles.container}>
        <div className={styles.footer}>
          <div className={styles.footerLeft}>
            <p>© Licensed under <a>MIT</a></p>
          </div>
          <div className={styles.footerRight}>
            <ul>
              <li>Donate</li>
              <li>Open source</li>
              <li>Developers</li>
              <li>Any issues?</li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
