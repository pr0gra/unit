"use client";

import * as yup from "yup";
import { useFormik } from "formik";

export default function Register() {
  const basicSchema = yup.object().shape({
    name: yup.string().required("Это обязательное поле"),
    surname: yup.string().required("Это обязательное поле"),
    email: yup
      .string()
      .email("Введите корректный Email")
      .required("Это обязательное поле"),

    phoneNumber: yup.string().required("Это обязательное поле"),
    birthdayDate: yup.string().required("Это обязательное поле"),
  });

  const { values, errors, touched, isSubmitting, handleChange, handleSubmit } =
    useFormik({
      initialValues: {
        name: "",
        surname: "",
        email: "",
        phoneNumber: "",
        birthdayDate: "",
      },
      onSubmit: (values) => {
        console.log(values);
      },
      validationSchema: basicSchema,
    });

  return (
    <div className="bg-gray-500 pb-20">
      <div className="text-4xl text-white py-8 flex justify-center">юнит</div>
      <form
        onSubmit={handleSubmit}
        className="max-w-lg w-full bg-white mx-auto rounded-2xl px-12 pb-12"
      >
        <div className="flex justify-center py-8 text-3xl">Регистрация</div>
        <div className="space-y-6">
          <input
            className="border border-neutral-300 rounded-2xl bg-neutral-200 py-4 w-full pl-12"
            type="text"
            id="name"
            placeholder="Имя"
            onChange={handleChange}
            value={values.name}
          />
          <input
            className="border border-neutral-300 rounded-2xl bg-neutral-200 py-4 w-full pl-12"
            type="text"
            id="surname"
            placeholder="Фамилия"
            onChange={handleChange}
            value={values.surname}
          />
          <input
            className="border border-neutral-300 rounded-2xl bg-neutral-200 py-4 w-full pl-12"
            type="text"
            id="email"
            placeholder="Электронная почта"
            onChange={handleChange}
            value={values.email}
          />
          <input
            className="border border-neutral-300 rounded-2xl bg-neutral-200 py-4 w-full pl-12"
            type="text"
            id="phoneNumber"
            placeholder="Номер телефона"
            onChange={handleChange}
            value={values.phoneNumber}
          />
          <input
            className="border border-neutral-300 rounded-2xl bg-neutral-200 py-4 w-full pl-12"
            type="text"
            id="birthdayDate"
            placeholder="Дата рождения"
            onChange={handleChange}
            value={values.birthdayDate}
          />
        </div>
        <div className="mt-6">
          <input type="checkbox" /> Ознакомлен с политикой конфиденциальности
        </div>
        <button
          typeof="submit"
          className="bg-black rounded-full text-white w-full py-4 mt-8 mb-2"
        >
          Зарегистрироваться
        </button>
      </form>
    </div>
  );
}
