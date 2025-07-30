# -*- coding: utf-8 -*-
import pandas as pd
import sys
import io
import matplotlib.pyplot as plt
import seaborn as sns

# Windows에서 한글 출력이 깨지는 현상을 방지하기 위해 stdout의 인코딩을 UTF-8로 설정합니다.
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

# 한글 폰트 설정 (Windows 11 기준)
plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['axes.unicode_minus'] = False # 마이너스 기호 깨짐 방지

# train.csv 파일을 DataFrame으로 로드합니다.
df = pd.read_csv("train.csv")

# --- 기본 데이터 분석 (출력은 생략) ---
df['Age'] = df['Age'].fillna(df['Age'].mean())
bins = [0, 12, 18, 60, 100]
labels = ['어린이', '청소년', '성인', '노인']
df['AgeGroup'] = pd.cut(df['Age'], bins=bins, labels=labels, right=False)
df['Embarked'].fillna(df['Embarked'].mode()[0], inplace=True)
df['FamilySize'] = df['SibSp'] + df['Parch'] + 1
df['FamilyGroup'] = '혼자'
df.loc[df['FamilySize'] > 1, 'FamilyGroup'] = '소규모'
df.loc[df['FamilySize'] > 4, 'FamilyGroup'] = '대규모'


# --- 데이터 시각화 (한글 레이블 적용) ---

# 1. 상관관계 히트맵
print("--- 상관관계 분석 ---")
numeric_cols = ['Survived', 'Pclass', 'Age', 'SibSp', 'Parch', 'Fare']
correlation_matrix = df[numeric_cols].corr()

plt.figure(figsize=(10, 8))
sns.heatmap(correlation_matrix, annot=True, cmap='coolwarm', fmt=".2f")
plt.title('타이타닉 특성 간의 상관관계')
plt.savefig('correlation_heatmap_kr.png')
print("한글 레이블이 적용된 상관관계 히트맵이 'correlation_heatmap_kr.png' 파일로 저장되었습니다.")


# 2. 성별과 객실 등급에 따른 생존율
plt.figure(figsize=(10, 6))
sns.barplot(x='Pclass', y='Survived', hue='Sex', data=df)
plt.title('객실 등급 및 성별에 따른 생존율')
plt.xlabel('객실 등급')
plt.ylabel('생존율')
plt.legend(title='성별')
plt.savefig('survival_by_sex_pclass_kr.png')
print("한글 레이블이 적용된 생존율 그래프가 'survival_by_sex_pclass_kr.png' 파일로 저장되었습니다.")


# 3. 연령대별 생존율
plt.figure(figsize=(10, 6))
sns.barplot(x='AgeGroup', y='Survived', data=df, order=labels, palette='viridis')
plt.title('연령대별 생존율')
plt.xlabel('연령대')
plt.ylabel('생존율')
plt.savefig('survival_by_agegroup_kr.png')
print("한글 레이블이 적용된 연령대별 생존율 그래프가 'survival_by_agegroup_kr.png' 파일로 저장되었습니다.")


# 4. 탑승 항구 및 가족 규모에 따른 생존율
fig, ax = plt.subplots(1, 2, figsize=(18, 6))

sns.barplot(x='Embarked', y='Survived', data=df, ax=ax[0])
ax[0].set_title('탑승 항구별 생존율')
ax[0].set_xlabel('탑승 항구')
ax[0].set_ylabel('생존율')

sns.barplot(x='FamilyGroup', y='Survived', data=df, order=['혼자', '소규모', '대규모'], ax=ax[1])
ax[1].set_title('가족 규모별 생존율')
ax[1].set_xlabel('가족 규모')
ax[1].set_ylabel('생존율')

plt.tight_layout()
plt.savefig('survival_by_embark_family_kr.png')
print("한글 레이블이 적용된 항구 및 가족 규모별 생존율 그래프가 'survival_by_embark_family_kr.png' 파일로 저장되었습니다.")