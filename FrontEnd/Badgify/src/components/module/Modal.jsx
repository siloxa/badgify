import { Note, XClose } from '../../data/Icon';
import styles from '../module/Modal.module.css';
function Modal() {
  return (
    <div className={styles.container}>
      <div className={styles.modal}>
        <div className={styles.modalBox}>
          <div className={styles.headBox}>
            <Note />
            <h6>Create customized Badge</h6>
            <button><XClose/></button>
          </div>
          <div className={styles.form}>
            <label htmlFor='badge'>Type</label>
            <select value="textBadge" name='badge'>
              <option value="textBadge">Text badge</option>
            </select>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Modal
