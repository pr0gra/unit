import Image from "next/image";
import styles from './Footer.module.css'

import unitLogo from '../../assets/icons/unit-logo.svg'
import Link from "next/link";

export  function Footer() {
  return (
    <footer className={styles['footer']}>
        <Link href={"https://vk.com/unit.usue"}>
          <Image className={styles['logo']} src={unitLogo} alt="logo"/>
          <h1 className={styles['text']}>юнит</h1>
        </Link>
    </footer>
  )
}
