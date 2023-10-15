"use client";
import Image from "next/image";
import styles from "./page.module.css";
import * as yup from "yup";
import { useFormik } from "formik";
import cx from "classnames";
import Link from "next/link";

import personIcon from "../../assets/icons/login-person.svg";
import horizontalLineIcon from "../../assets/icons/horizontal-line.svg";
import keyIcon from "../../assets/icons/password-key.svg";

export default function Login() {
  const basicSchema = yup.object().shape({
    name: yup.string().required("Это обязательное поле"),
    password: yup.string().required("Это обязательное поле"),
  });
  const { values, errors, touched, isSubmitting, handleChange, handleSubmit } =
    useFormik({
      initialValues: {
        name: "",
        password: "",
      },
      onSubmit: (values) => {
        console.log(values);
      },
      validationSchema: basicSchema,
    });
  return (
    <div className={styles["registration"]}>
      <form onSubmit={handleSubmit} className={styles["form-part"]}>
        <h2 className={styles["form-title"]}>Добро пожаловать!</h2>
        <div className={styles["input-container"]}>
          <Image src={personIcon} alt="" />
          <input
            className={styles["input"]}
            type="text"
            id="name"
            placeholder="Имя"
            onChange={handleChange}
            value={values.name}
          />
        </div>
        <div className={styles["input-container"]}>
          <Image src={keyIcon} alt="" />
          <input
            className={styles["input"]}
            type="text"
            id="password"
            placeholder="Пароль"
            onChange={handleChange}
            value={values.password}
          />
        </div>
        {!isSubmitting ? (
          <button typeof="submit" className={styles["button"]}>
            Войти
          </button>
        ) : (
          <button
            disabled
            typeof="submit"
            className={cx(styles["button"], styles["button-disabled"])}
          >
            Отправлено
          </button>
        )}
        <Image
          className={styles["horizontal-line"]}
          src={horizontalLineIcon}
          alt=""
        />
        <p className={styles["text"]}>Вы не зарегистрированы?</p>
        <Link href={"/registration"} className={styles["registration-link"]}>
          Регистрация
        </Link>
      </form>
    </div>
  );
}
