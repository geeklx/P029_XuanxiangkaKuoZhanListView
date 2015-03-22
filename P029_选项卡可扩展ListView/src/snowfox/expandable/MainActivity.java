package snowfox.expandable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ExpandableListView elv;
	private Activity activity;
	private View addHeaderView_layout;
	private View addFooterView_layout;
	private TextView gongnengshezhi_content_layout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex_main);

		// ����չѡ�����
		initView();
	}

	/*
	 * ����չѡ�����
	 */
	private void initView() {
		elv = (ExpandableListView) findViewById(R.id.expandableListView1);
		activity = MainActivity.this;
		// ����չ�б���
		// ׼��һ���б�����ʾ������:2��һ���б�,�ֱ���ʾ"group1"��"group2"
		List<Map<String, String>> groups = new ArrayList<Map<String, String>>();
		Map<String, String> group1 = new HashMap<String, String>();
		group1.put("group", "�����г�");
		groups.add(group1);
		// ׼����һ��һ���б��еĶ����б�����:���������б�,�ֱ���ʾ"childData1"��"childData2"
		List<Map<String, String>> child1 = new ArrayList<Map<String, String>>();
		Map<String, String> child1Data1 = new HashMap<String, String>();
		child1Data1.put("child", "���˳���");
		Map<String, String> child1Data2 = new HashMap<String, String>();
		child1Data2.put("child", "������");
		Map<String, String> child1Data3 = new HashMap<String, String>();
		child1Data3.put("child", "���˽���");
		Map<String, String> child1Data4 = new HashMap<String, String>();
		child1Data4.put("child", "�ղ�");
		Map<String, String> child1Data5 = new HashMap<String, String>();
		child1Data5.put("child", "����");
		Map<String, String> child1Data6 = new HashMap<String, String>();
		child1Data6.put("child", "����");
		child1.add(child1Data1);
		child1.add(child1Data2);
		child1.add(child1Data3);
		child1.add(child1Data4);
		child1.add(child1Data5);
		child1.add(child1Data6);

		Map<String, String> group2 = new HashMap<String, String>();
		group2.put("group", "ȦȦ");
		groups.add(group2);
		// ׼����һ��һ���б��еĶ����б�����:���������б�,�ֱ���ʾ"childData1"��"childData2"
		List<Map<String, String>> child2 = new ArrayList<Map<String, String>>();
		Map<String, String> child2Data1 = new HashMap<String, String>();
		child2Data1.put("child", "�ҵ���ҳ");
		Map<String, String> child2Data2 = new HashMap<String, String>();
		child2Data2.put("child", "�ҵ�Ȧ��");
		Map<String, String> child2Data3 = new HashMap<String, String>();
		child2Data3.put("child", "�ҵĻ���");
		Map<String, String> child2Data4 = new HashMap<String, String>();
		child2Data4.put("child", "�ҵĻ");
		Map<String, String> child2Data5 = new HashMap<String, String>();
		child2Data5.put("child", "�ҵ�˽��");
		Map<String, String> child2Data6 = new HashMap<String, String>();
		child2Data6.put("child", "������");
		Map<String, String> child2Data7 = new HashMap<String, String>();
		child2Data7.put("child", "�ȼ�����");
		child2.add(child2Data1);
		child2.add(child2Data2);
		child2.add(child2Data3);
		child2.add(child2Data4);
		child2.add(child2Data5);
		child2.add(child2Data6);
		child2.add(child2Data7);
		// ��һ��list���󱣴����еĶ����б�����
		List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
		childs.add(child1);
		childs.add(child2);

		ExpandableAdapter1 viewAdapter = new ExpandableAdapter1(activity, this,
				groups, childs);

		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		addFooterView_layout = inflater.inflate(R.layout.addfooterview_layout,
				null);
		gongnengshezhi_content_layout = (TextView) addFooterView_layout
				.findViewById(R.id.gongnengshezhi_content);

		// addHeaderView_layout =
		// inflater.inflate(R.layout.addheaderview_layout,
		// null);
		// elv.addHeaderView(addHeaderView_layout);
		elv.addFooterView(addFooterView_layout);
		gongnengshezhi_content_layout
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MainActivity.this,
								OtherActivity.class);
						startActivity(intent);
						MainActivity.this.finish();
					}
				});
		elv.setGroupIndicator(null);
		elv.setAdapter(viewAdapter);

	}

}