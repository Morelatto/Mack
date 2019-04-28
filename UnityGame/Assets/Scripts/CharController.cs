using System.Collections;
using UnityEngine;
using UnityEngine.UI;


public class CharController : MonoBehaviour {
	public float speed;
	public AudioSource coinaudio;
	public Text scorePanel;

	int xp;
	bool isMoving, roadCollide;
	Vector3 pos, pos_0;

	void Start () {
		isMoving = false;
		roadCollide = true;
		speed = 4.0f;
		xp = 0;
		pos = transform.position;
	}

	void Update () {
		if (!isMoving) {
			isMoving = true;
			if (transform.position == pos) {
				pos_0 = transform.position;
				if (Input.GetKey (KeyCode.D) || Input.GetKey (KeyCode.RightArrow)) {
					pos += Vector3.right;
				} else if (Input.GetKey (KeyCode.A) || Input.GetKey (KeyCode.LeftArrow)) {
					pos += Vector3.left;
				} else if (Input.GetKey (KeyCode.W) || Input.GetKey (KeyCode.UpArrow)) {
					pos += Vector3.up;
				} else if (Input.GetKey (KeyCode.S) || Input.GetKey (KeyCode.DownArrow)) {
					pos += Vector3.down;
				}
			}
			transform.position = Vector3.MoveTowards(transform.position, pos, Time.deltaTime*speed);
			isMoving = false;
		}
		if (!roadCollide) {
			transform.position = pos_0;
			isMoving = false;
			roadCollide = true;
			pos = pos_0;
		}
	}

	void OnCollisionEnter2D(Collision2D other){
		if (other.gameObject.tag == "Item") {
			coinaudio.Play ();
			scorePanel.text = ++xp + "";
			if (xp == 4) {
				Application.LoadLevel (2);
			}
			if (speed < 11) {
				speed++;
			}
			Destroy (other.gameObject);
		} else {
			roadCollide = false;
			if (speed > 4) {
				speed--;
			}
		}
	}

	void OnCollisionStay2D(Collision2D other){
		if (other.gameObject.tag != "Item") {
			roadCollide = false;
		}
	}
}
