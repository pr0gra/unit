"use client";

import Image from "next/image";
import * as yup from "yup";
import { useFormik } from "formik";
import cx from "classnames";
import Link from "next/link";

import personIcon from "../components/login-person.svg";
import horizontalLineIcon from "../components/horizontal-line.svg";
import keyIcon from "../components/password-key.svg";

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
    <div className="">
      <form onSubmit={handleSubmit} className="">
        <h2 className="">Добро пожаловать!</h2>
        <div className="">
          <Image src={personIcon} alt="" />
          <input
            className=""
            type="text"
            id="name"
            placeholder="Имя"
            onChange={handleChange}
            value={values.name}
          />
        </div>
        <div className="">
          <Image src={keyIcon} alt="" />
          <input
            className=""
            type="text"
            id="password"
            placeholder="Пароль"
            onChange={handleChange}
            value={values.password}
          />
        </div>
        {!isSubmitting ? (
          <button typeof="submit" className="">
            Войти
          </button>
        ) : (
          <button disabled typeof="submit" className={cx("", "")}>
            Отправлено
          </button>
        )}
        <Image className="" src={horizontalLineIcon} alt="" />
        <p className="">Вы не зарегистрированы?</p>
        <Link href={"/registration"} className="">
          Регистрация
        </Link>
      </form>
    </div>
  );
}
