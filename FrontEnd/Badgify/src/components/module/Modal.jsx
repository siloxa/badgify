import styles from '../module/Modal.module.css';
function Modal() {
  return (
    <div className={styles.container}>
      <div className={styles.modal}>
        <div className={styles.modalBox}>
          <div className={styles.headBox}>
            <h6>Create customized Badge</h6>
          </div>
          
        </div>
      </div>
    </div>
  )
}

export default Modal
