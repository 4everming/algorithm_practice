#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

	freopen("water.in", "r", stdin);

	int i, j;
	int n;
	int x[300], x_dajing[300], x_value[300];
	int matrix[300][300];

	scanf("%d", &n);

	for(i=0; i<n; i++)
	{
		scanf("%d", &x[i]);
	}

	for(i=0; i<n; i++)
	{
		for(j=0; j<n; j++)
		{
			scanf("%d", &matrix[i][j]);
		}
	}

	for(i=0; i<n; i++)
	{
		x_dajing[i] = 1;   //��ʼ״̬ʹÿ�����㶼�о�
		x_value[i] = x[i]; //i����򾮵Ļ���
	}

	int n_dajing = n;
	int changed = 0;
	while(1)
	{
		changed = 0;
		for(i=0; i<n; i++)  //һ����n������
		{
			for(j=0; j<n; j++)
			{
				if(i==j) continue;  //�����Լ����Լ� Ȩֵ��0

				if(x_dajing[i] == 1)
				{                 //�����������о�
					if(x_value[i] >= (x_value[j] + matrix[i][j])) //��������j����򾮵Ļ���Ҫ���� ��j����򾮲��޹ܵ�����i�����Ǯ�Ļ����������ľ�ȥ��
					{
						x_value[i] = matrix[i][j]; //????   ���������Ȩֵ��Ϊ������ͨE(i,j)�ߵ�Ȩֵ
						x_dajing[i] = 0;    //�������ľ�ȥ����
						n_dajing--;            //���ĸ�����һ  �������û���õ���
						changed = 1;
					}
				}else{            //����������û�о�(���Ѿ����Ƴ�����)
					if(x_value[i] >= (x_value[j] + matrix[i][j])) // ��� �ϴ������������ͨ�ıߵ�Ȩֵ���� ��������������ߵ�Ȩֵ+��������򾮵Ļ��ѵĺ�
					{
						x_value[i] = x_value[j] + matrix[i][j];   //���������Ȩֵ���³������С��ֵ
						changed = 1;
					}
				}
			}
		}
		if(changed == 0)
			break;   //�˴�ѭ�����ϴ�ѭ��û���κθı䣬��ֹѭ��
	}

	int min_value = 0;
	for(i=0; i<n; i++)
	{
		min_value += x_value[i];  //�е��С����
	}

	freopen("water.out", "w", stdout);

	printf("%d", min_value);

	return 0;
}
