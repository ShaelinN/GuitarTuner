<script>
    let allNotes = ["A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"]
    const CONCERT_PITCH = 440;

    function noteOfPitch(pitch) {
        hsteps = Math.trunc(Math.log2(pitch/CONCERT_PITCH) * 12)
        letter = allNotes[mod(hsteps, 12)]
        number = 4 + Math.trunc ((hsteps + 9) / 12)
        return letter + number.toString()
    }

    function mod(n, m) {
        return ((n % m) + m) % m;
    }

    $: note = noteOfPitch(value);

</script>
<h1>{note}</h1>