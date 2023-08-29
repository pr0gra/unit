import Image from "next/image";
import styles from "./Header.module.css";

import logoHeader from "../../assets/icons/header-logo.svg";
import Link from "next/link";

export function Header() {
  return (
    <header className={styles["header"]}>
      <Link href={"https://vk.com/unit.usue"}><Image src={logoHeader} alt="logo"></Image></Link>
      <nav className={styles["navigation"]}>
        <ul className={styles["navigation-array"]}>
          <li
            style={{ borderRadius: "22px", background: "#FFF" }}
            className={styles["navigation-element"]}
          >
            <Link
              style={{ color: "black"}}
              className={styles["link"]}
              href={"/"}
            >
              О нас
            </Link>{" "}
          </li>
          <li className={styles["navigation-element"]}>
            <Link style={{color: "rgb(246 249 232 / 16%)"}} className={styles["link"]} href={"/"}>
              Проекты
            </Link>
          </li>
          <li className={styles["navigation-element"]}>
            <Link style={{color: "rgb(246 249 232 / 16%)"}} className={styles["link"]} href={"/"}>
              Авторы
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
