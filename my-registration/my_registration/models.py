from django.db import models


# Create your models here.

# class Person(models.Model):
#     name = models.CharField(max_length=100)
#     email = models.EmailField(blank=False, max_length=100)
#     cpf = models.CharField(max_length=11, unique=True)
#     rg = models.CharField(max_length=9)
#     phone = models.CharField(max_length=14)
#
#
# class Professor(models.Model):
#     person = models.OneToOneField(
#         Person,
#         on_delete=models.CASCADE,
#         primary_key=True,
#     )
#
#
# class Course(models.Model):
#     person = models.OneToOneField(
#         Person,
#         on_delete=models.CASCADE,
#         primary_key=True,
#     ),
#     professor = models.ForeignKey(Professor, on_delete=models.SET_NULL)
#
#
# class Student(models.Model):
#     person = models.OneToOneField(
#         Person,
#         on_delete=models.CASCADE,
#         primary_key=True,
#     ),
#     course = models.ForeignKey(Course, on_delete=models.SET_NULL)
#
#
# class Register(models.Model):
#     student = models.OneToOneField(
#         Person,
#         on_delete=models.CASCADE,
#         primary_key=True,
#     ),





